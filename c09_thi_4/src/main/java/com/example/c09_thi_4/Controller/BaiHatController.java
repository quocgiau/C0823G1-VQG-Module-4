package com.example.c09_thi_4.Controller;

import com.example.c09_thi_4.DTO.BaiHatDTO;
import com.example.c09_thi_4.Model.BaiHat;
import com.example.c09_thi_4.Model.TheLoai;
import com.example.c09_thi_4.Service.IBaiHatService;
import com.example.c09_thi_4.Service.ITheLoaiService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BaiHatController {
    @Autowired
    private IBaiHatService service;
    @Autowired
    private ITheLoaiService theLoaiService;

    @ModelAttribute("theLoai")
    private List<TheLoai> getList() {
        return theLoaiService.getAll();
    }

//    @GetMapping("/")
//    public String xem(@PageableDefault(value = 2) Pageable pageable, Model model) {
//        Page<BaiHat> baiHats = service.getList(pageable);
//        model.addAttribute("baiHat", baiHats);
//        return "home";
//    }

    @PostMapping("/xoa")
    public String xoa(@RequestParam("id") int id) {
        BaiHat baiHat = service.findById(id);
        service.delete(baiHat);
        return "redirect:/";
    }

    @GetMapping("/them")
    public String them(Model model) {
        model.addAttribute("baiHat", new BaiHatDTO());
        return "add";
    }

    @PostMapping("/them")
    public String themMoi(@Valid @ModelAttribute("baiHat") BaiHatDTO baiHatDTO,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("baiHat", baiHatDTO);
            return "add";
        }
        BaiHat baiHat = new BaiHat();
        BeanUtils.copyProperties(baiHatDTO, baiHat);
        service.save(baiHat);
        return "redirect:/";
    }

    //    @PostMapping("/tim")
//    private String tim(@RequestParam("name-search") String name, @PageableDefault(value = 2) Pageable pageable, Model model) {
//        Page<BaiHat> baiHats = service.findByNameContaining(name, pageable);
//        model.addAttribute("baiHat", baiHats);
//        return "home";
//    }
    @GetMapping("/")
    public String xem(@RequestParam(value = "name-search", required = false) String name,
                      @RequestParam(value = "card-search", required = false) String card,
                      @PageableDefault(value = 2) Pageable pageable,
                      Model model) {
        Page<BaiHat> baiHats;

        if (name != null && !name.isEmpty() && (card == null || card.isEmpty())) {
            // Nếu chỉ tìm kiếm theo tên bài hát
            baiHats = service.findByNameContaining(name, pageable);
        } else if (card != null && !card.isEmpty() && (name == null || name.isEmpty())) {
            // Nếu chỉ tìm kiếm theo tên tác giả
            baiHats = service.findByCardContaining(card, pageable);
        } else if (name != null && !name.isEmpty() && card != null && !card.isEmpty()) {
            // Nếu tìm kiếm cả hai (tên bài hát và tên tác giả)
            baiHats = service.findByNameContainingAndCardContaining(name, card, pageable);
        } else {
            // Nếu không có dữ liệu tìm kiếm, hiển thị danh sách ban đầu
            baiHats = service.getList(pageable);
        }

        model.addAttribute("baiHat", baiHats);
        return "home";
    }


}
