package com.spring.spring_project.UI;

import com.spring.spring_project.API.Server;
import com.spring.spring_project.Model.Dto.Item;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebPageController {


    @Autowired
    Server server;

    public WebPageController(Server server) {
        this.server = server;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "UI Home");

        model.addAttribute("items", server.getItems());

        return "index";
    }

    @GetMapping("/items")
    public String items(Model model) {
        model.addAttribute("title", "UI Home");

        model.addAttribute("items", server.getItems());

        return "items";
    }

    @GetMapping("/items/new")
    public String showAddForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("title", "Add item");
        return "addEditPage";
    }

    @PostMapping("/add/items")
    public String saveItem(@Valid @ModelAttribute("item") Item item, Model model) {
        boolean ok = server.addItem(item);
        if (ok) return "redirect:/items";

        model.addAttribute("title", "Add item");
        model.addAttribute("error", "Fail to save item");
        return "addEditPage";
    }

    @GetMapping("/items/{id}/edit")
    public String showEditForm(Model model,@PathVariable @NotNull long id) {
        Item item = server.getItemById(id);
        if (item == null) {
            return "redirect:/items";
        }

        model.addAttribute("title", "Edit item");
        model.addAttribute("item", item);
        model.addAttribute("mode", "edit");
        model.addAttribute("id", id);
        return "addEditPage";
    }

    @PostMapping("/items/edit/{id}")
    public String editItem(@PathVariable long id, @ModelAttribute("item") Item item, Model model) {
        if (server.editItem(id, item)) return "redirect:/items";

        model.addAttribute("title", "Edit item");
        model.addAttribute("mode", "edit");
        model.addAttribute("id", id);
        model.addAttribute("error", "Fail to update item");
        return "addEditPage";
    }
}