package com.example.demo.Controler;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarCategory;
import com.example.demo.Model.CreateItemForm;
import com.example.demo.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class CarController {

    private final ItemService store;

    public CarController(ItemService store) {
        this.store = store;
    }

    // LIST
    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", store.getStorageValues());
        return "list";
    }

    // CREATE FORM
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("title", "Add item");
        model.addAttribute("mode", "add");
        model.addAttribute("form", new CreateItemForm());
        model.addAttribute("categories", CarCategory.values());
        return "new";
    }

    // DETAILS PAGE
    @GetMapping("/{id}")
    public String details(Model model, @PathVariable long id) {
        Car item = null;// = store.getStorageValues(id);
        if (item == null) return "redirect:/items";

        model.addAttribute("items", List.of(item));
        return "car";
    }

    // CREATE POST
    @PostMapping
    public String create(@Valid @ModelAttribute("form") CreateItemForm form,
                         BindingResult br,
                         Model model) {

        if (br.hasErrors()) {
            model.addAttribute("title", "Add item");
            model.addAttribute("mode", "add");
            model.addAttribute("categories", CarCategory.values());
            return "new";
        }
        boolean ok = true;
//   boolean ok     = store.setStorageValues(
//                form.getName().trim(),
//                form.getColor().trim(),
//                form.getDetails().trim(),
//                form.getModel().trim(),
//                form.getCategory(),
//                form.getName() + ", asd"
//        );

        return ok ? "redirect:/items" : "redirect:/403";
    }

    // EDIT FORM
    @GetMapping("/{id}/edit")
    public String showEditForm(Model model, @PathVariable long id) {
        Car item=null;// = store.getById(id);
        if (item == null) return "redirect:/items";

        CreateItemForm form = new CreateItemForm();
        form.setName(item.getName());
        form.setColor(item.getColor());
        form.setDetails(item.getDetails());
        form.setModel(item.getModel());
        form.setCategory(item.getCategory());

        model.addAttribute("title", "Edit item");
        model.addAttribute("mode", "edit");
        model.addAttribute("id", id);
        model.addAttribute("form", form);
        model.addAttribute("categories", CarCategory.values());
        return "new";
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable long id,
                         @Valid @ModelAttribute("form") CreateItemForm form,
                         BindingResult br,
                         Model model) {

        if (br.hasErrors()) {
            model.addAttribute("title", "Edit item");
            model.addAttribute("mode", "edit");
            model.addAttribute("id", id);
            model.addAttribute("categories", CarCategory.values());
            return "new";
        }

        boolean ok =true;//= store.updateObject(
//                new Car(
//                        form.getName().trim(),
//                        form.getColor().trim(),
//                        form.getDetails().trim(),
//                        form.getModel().trim(),
//                        form.getCategory(), form.getName() + ", asd")
//        );

        return ok ? "redirect:/items" : "redirect:/403";
    }
}
