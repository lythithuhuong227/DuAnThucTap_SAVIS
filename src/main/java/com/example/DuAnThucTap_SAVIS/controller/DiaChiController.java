package com.example.DuAnThucTap_SAVIS.controller;

import com.example.DuAnThucTap_SAVIS.entity.DiaChi;
import com.example.DuAnThucTap_SAVIS.model.request.create_request.CreateDiaChiRequest;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateDiaChiRequest;
import com.example.DuAnThucTap_SAVIS.model.response.DiaChiResponse;
import com.example.DuAnThucTap_SAVIS.model.response.KhachHangResponse;
import com.example.DuAnThucTap_SAVIS.service.DiaChiService;
import com.example.DuAnThucTap_SAVIS.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/admin/psg/dia-chi")
public class DiaChiController {

    @Autowired
    DiaChiService diaChiService;

    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, HttpSession session) {
        if (session.getAttribute("successMessage") != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            model.addAttribute("successMessage", successMessage);
            session.removeAttribute("successMessage");
        }
        model.addAttribute("diaChi", new DiaChi());
        return pageDiaChiActive(0, model);
    }

    @GetMapping("/pageActive/{pageNo}")
    public String pageDiaChiActive(@PathVariable("pageNo") Integer pageNo, Model model) {
        model.addAttribute("diaChi", new DiaChi());
        Page<DiaChiResponse> diaChiResponsePageActive = diaChiService.pageDiaChiActive(pageNo, 3);
        model.addAttribute("size", diaChiResponsePageActive.getSize());
        model.addAttribute("totalPages", diaChiResponsePageActive.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listDiaChiActive", diaChiResponsePageActive);
        return "admin/dia_chi/trang_chu_dia_chi";
    }

    @GetMapping("/pageInActive/{pageNo}")
    public String pageDiaChiInActive(@PathVariable("pageNo") Integer pageNo, Model model) {
        Page<DiaChiResponse> diaChiResponsePageInActive = diaChiService.pageDiaChiInActive(pageNo, 3);
        model.addAttribute("size", diaChiResponsePageInActive.getSize());
        model.addAttribute("totalPages", diaChiResponsePageInActive.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listDiaChiInActive", diaChiResponsePageInActive);
        return "admin/dia_chi/revert_dia_chi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        List<KhachHangResponse> khachHangList = khachHangService.getAllKhachHangActive();
        model.addAttribute("khachHangList", khachHangList);

        DiaChiResponse diaChiResponse = diaChiService.getOne(id);
        model.addAttribute("diaChi", diaChiResponse);
        return "admin/dia_chi/view_update_dia_chi";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        List<KhachHangResponse> khachHangList = khachHangService.getAllKhachHangActive();
        model.addAttribute("khachHangList", khachHangList);
        model.addAttribute("diaChi", new CreateDiaChiRequest());
        return "admin/dia_chi/view_add_dia_chi";
    }

    @PostMapping("/delete/{id}")
    public String deleteDiaChi(@PathVariable("id") Integer id, HttpSession session) {
        diaChiService.deleteDiaChi(id, LocalDate.now());
        session.setAttribute("successMessage", "Xóa thành công!");
        return "redirect:/admin/psg/dia-chi/hien-thi";
    }

    @PostMapping("/revert/{id}")
    public String revertDiaChi(@PathVariable("id") Integer id, HttpSession session) {
        diaChiService.revertDiaChi(id, LocalDate.now());
        session.setAttribute("successMessage", "Khôi phục thành công!");
        return "redirect:/admin/psg/dia-chi/hien-thi";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("diaChi") CreateDiaChiRequest createDiaChiRequest, BindingResult result, Model model, HttpSession session) {
        if (StringUtils.isEmpty(createDiaChiRequest.getSdt())) {
            result.rejectValue("sdt", "field.empty", "Số điện thoại không được để trống");
        } else if (!Pattern.matches("\\d{10}", createDiaChiRequest.getSdt())) {
            result.rejectValue("sdt", "field.invalid", "Số điện thoại phải đúng 10 kí tự");
        }
        if (result.hasErrors()) {
            List<KhachHangResponse> khachHangList = khachHangService.getAllKhachHangActive();
            model.addAttribute("khachHangList", khachHangList);
            return "admin/dia_chi/view_add_dia_chi";
        }
        diaChiService.add(createDiaChiRequest);
        session.setAttribute("successMessage", "Thêm thành công!");
        System.out.println("loi");
        return "redirect:/admin/psg/dia-chi/hien-thi";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("diaChi") UpdateDiaChiRequest updateDiaChiRequest, BindingResult result, Model model, HttpSession session) {
        if (StringUtils.isEmpty(updateDiaChiRequest.getSdt())) {
            result.rejectValue("sdt", "field.empty", "Số điện thoại không được để trống");
        } else if (!Pattern.matches("\\d{10}", updateDiaChiRequest.getSdt())) {
            result.rejectValue("sdt", "field.invalid", "Số điện thoại phải đúng 10 kí tự");
        }
        if (result.hasErrors()) {
            List<KhachHangResponse> khachHangList = khachHangService.getAllKhachHangActive();
            model.addAttribute("khachHangList", khachHangList);
            model.addAttribute("diaChi", updateDiaChiRequest);
            return "admin/dia_chi/view_update_dia_chi";
        }
        diaChiService.update(updateDiaChiRequest);
        session.setAttribute("successMessage", "Cập nhập thành công!");
        return "redirect:/admin/psg/dia-chi/hien-thi";
    }

    @GetMapping("/searchActive/{pageNo}")
    public String searchActive(Model model, @PathVariable("pageNo") Integer pageNo, @RequestParam("searchNameOrMa") String searchNameOrMa) {
        model.addAttribute("diaChi", new DiaChi());
        Page<DiaChiResponse> diaChiResponsePage = diaChiService.searchNameOrMaActive(searchNameOrMa, pageNo, 3);
        model.addAttribute("size", diaChiResponsePage.getSize());
        model.addAttribute("totalPages", diaChiResponsePage.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listDiaChiActive", diaChiResponsePage);
        return "admin/dia_chi/trang_chu_dia_chi";
    }

    @GetMapping("/searchInActive/{pageNo}")
    public String searchInActive(Model model, @PathVariable("pageNo") Integer pageNo, @RequestParam("searchNameOrMa") String searchNameOrMa) {
        model.addAttribute("diaChi", new DiaChi());
        Page<DiaChiResponse> diaChiResponsePage = diaChiService.searchNameOrMaInActive(searchNameOrMa, pageNo, 3);
        model.addAttribute("size", diaChiResponsePage.getSize());
        model.addAttribute("totalPages", diaChiResponsePage.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listDiaChiInActive", diaChiResponsePage);
        return "admin/dia_chi/revert_dia_chi";
    }

}
