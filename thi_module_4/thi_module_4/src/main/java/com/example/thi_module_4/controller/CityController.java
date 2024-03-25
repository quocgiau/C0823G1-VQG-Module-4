package com.example.thi_module_4.controller;

import com.example.thi_module_4.model.City;
import com.example.thi_module_4.model.CityDTO;
import com.example.thi_module_4.model.Country;
import com.example.thi_module_4.service.ICityService;
import com.example.thi_module_4.service.ICountryService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @ModelAttribute("country")
    private List<Country> countryList() {
        return countryService.findAll();
    }

    @GetMapping
    public String showList(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("city", cities);
        return "city";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("city", new CityDTO());
//        List<Country> countryList = countryService.findAll();
//        model.addAttribute("country", countryList);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("city") CityDTO cityDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("message", "Cập nhật không thành công");
            return "create";
        }
        City city = new City();
        BeanUtils.copyProperties(cityDTO, city);
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/city";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        City city = cityService.findById(id);
        CityDTO cityDTO = new CityDTO();
        BeanUtils.copyProperties(city, cityDTO);
        model.addAttribute("city", cityDTO);
        return "create";
    }

    @PostMapping("/{id}/edit")
    public String save(@Valid @ModelAttribute("city") CityDTO cityDTO, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("message", "Cập nhật không thành công");
            return "create";
        }
        City city = cityService.findById(id);
        BeanUtils.copyProperties(cityDTO, city);
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/city";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("idDelete") Long id,
                         RedirectAttributes redirectAttributes) {
        City city = cityService.findById(id);
        cityService.delete(city);
        redirectAttributes.addFlashAttribute("message", "Xóa thành phố " + city.getName() + " thành công");
        return "redirect:/city";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") Long id,
                         Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "detail";
    }

    @GetMapping("/{id}/delete1")
    public String delete(@PathVariable("id") Long id,
                         Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "delete";
    }
}
