package com.example.demo.Controler;

import com.example.demo.items.CreateItemForm;
import com.example.demo.items.InMemoryItemStore;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final InMemoryItemStore store;

    public ItemController(InMemoryItemStore store) {
        this.store = store;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("items", store.findAll());
        return "items/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("form", new CreateItemForm());
        return "items/new";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("form") CreateItemForm form,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "items/new";
        }
        store.save(form.getName().trim());
        return "redirect:/items";
    }
}
