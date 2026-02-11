package com.example.demo.Controler;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Model.CreateItemForm;
import com.example.demo.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class CarController {

    private final ItemService store;

    public CarController(ItemService store) {
        this.store = store;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String search, Model model, Authentication authentication) {
        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("items", store.findAllByName(search));
        } else {
            model.addAttribute("items", store.getStorageValues());
        }

        model.addAttribute("search", search);
        model.addAttribute("isAdmin", authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
        return "list";
    }

    @GetMapping("/new")
    public String newItemForm(Model model, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/403";
        }
        model.addAttribute("form", new CreateItemForm());
        model.addAttribute("categories", CarCategory.values());
        return "new";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("form") CreateItemForm form,
                         BindingResult br,
                         RedirectAttributes redirectAttributes,
                         Model model,
                         Authentication authentication) {

        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/403";
        }

        if (br.hasErrors()) {
            model.addAttribute("categories", CarCategory.values());
            return "new";
        }

        // FIXED PARAM ORDER: name, color, details, model, category, add
        boolean ok = store.setStorageValues(
                form.getName(),
                form.getColor(),
                form.getDetails(),
                form.getModel(),
                form.getCategory(),
                form.getAdd()
        );

        if (ok) redirectAttributes.addFlashAttribute("message", "Car created successfully!");
        else redirectAttributes.addFlashAttribute("error", "Failed to create car!");

        return "redirect:/items";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable long id, Model model) {
        var item = store.getById(id);
        model.addAttribute("item", item);   // FIX: DO NOT overwrite with null
        return "details";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/403";
        }

        var item = store.getById(id);
        if (item == null) return "redirect:/items";

        var form = new CreateItemForm();
        form.setName(item.getName());
        form.setModel(item.getModel());
        form.setColor(item.getColor());
        form.setDetails(item.getDetails());
        form.setCategory(item.getCategory());
        form.setAdd(item.getAdditionalInfo()); // FIX: keep existing add

        model.addAttribute("form", form);
        model.addAttribute("categories", CarCategory.values());
        model.addAttribute("editId", id);
        return "edit";
    }

    // FIX: match the HTML form (method="post")
    @PostMapping("/{id}/edit")
    public String update(@PathVariable long id,
                         @Valid @ModelAttribute("form") CreateItemForm form,
                         BindingResult br,
                         RedirectAttributes redirectAttributes,
                         Model model,
                         Authentication authentication) {

        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/403";
        }

        if (br.hasErrors()) {
            model.addAttribute("categories", CarCategory.values());
            model.addAttribute("editId", id);
            return "edit";
        }

        // FIXED CONSTRUCTOR ORDER: id, name, color, details, model, category, add
        boolean ok = store.editStorageValues(new Car(
                id,
                form.getName(),
                form.getColor(),
                form.getDetails(),
                form.getModel(),
                form.getCategory(),
                form.getAdd()
        ));

        if (ok) redirectAttributes.addFlashAttribute("message", "Car updated successfully!");
        else redirectAttributes.addFlashAttribute("error", "Failed to update car!");

        return "redirect:/items";
    }
}
