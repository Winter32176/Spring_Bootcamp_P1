package com.example.demo.Controler;

import com.example.demo.Model.CarCategory;
import com.example.demo.Model.CreateItemForm;
import com.example.demo.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping("/items")
public class CarController {

    private final ItemService store;

    public CarController(ItemService store) {
        this.store = store;
    }

    @GetMapping()
    public String list(Model model) {
        model.addAttribute("items", store.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("form", new CreateItemForm());
        model.addAttribute("categories", CarCategory.values());
        return "new";
    }

    @GetMapping("/{id}")
    public String list(Model model, @PathVariable long id) {
        model.addAttribute("items", store.getById(id));
        return "Car";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("form") CreateItemForm form,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "new";
        return store.saveObject(form.getName().trim(), form.getColor(), form.getDetails(), form.getModel(), form.getCategory()) ? "redirect:/items" : "redirect:/403";
    }
}

