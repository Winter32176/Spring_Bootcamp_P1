package com.example.demo.Controler;

import com.example.demo.Model.CreateItemForm;
import com.example.demo.Repository.InMemoryItemRepository;
import com.example.demo.Service.ItemService;
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

    private final ItemService store;

    public ItemController(ItemService store) {
        this.store = store;
    }

    @GetMapping()
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
