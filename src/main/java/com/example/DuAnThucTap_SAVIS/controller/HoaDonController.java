package com.example.DuAnThucTap_SAVIS.controller;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.model.request.update_request.UpdateHoaDonRequest;
import com.example.DuAnThucTap_SAVIS.model.response.HoaDonChiTietResponse;
import com.example.DuAnThucTap_SAVIS.model.response.HoaDonResponse;
import com.example.DuAnThucTap_SAVIS.service.ChiTietSanPhamService;
import com.example.DuAnThucTap_SAVIS.service.HoaDonService;
import com.example.DuAnThucTap_SAVIS.service.KhachHangService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/psg/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/hoa-don-cho")
    public String hoaDonCho(Model model){
        model.addAttribute("listHoaDonCho", hoaDonService.getAllHoaDonCho());
        model.addAttribute("listCtsp", chiTietSanPhamService.getAllChiTietSanPham());
        model.addAttribute("listKhachHang", khachHangService.getAllKhachHangActive());
        model.addAttribute("phuongThucThanhToan", ApplicationConstant.HinhThucThanhToan.values());
        return "admin/hoa_don/hoa_don_cho";
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, HttpSession session) {
        if (session.getAttribute("successMessage") != null) {
            String successMessage = (String) session.getAttribute("successMessage");
            model.addAttribute("successMessage", successMessage);
            session.removeAttribute("successMessage");
        }
        return pageHoaDonActive(0, model);
    }

    @GetMapping("/pageActive/{pageNo}")
    public String pageHoaDonActive(@PathVariable("pageNo") Integer pageNo, Model model) {
        Page<HoaDonResponse> hoaDonResponsePageActive = hoaDonService.pageHoaDon(pageNo, 10);

        // Định dạng tiền tệ Việt Nam
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        for (HoaDonResponse hd : hoaDonResponsePageActive) {
            BigDecimal thanhTien = hd.getThanhTien();
            String formattedThanhTien = currencyFormat.format(thanhTien);
            hd.setFormattedThanhTien((formattedThanhTien));
        }
        model.addAttribute("trangThaiHD", ApplicationConstant.TrangThaiHoaDon.values());
        model.addAttribute("trangThaiBH", ApplicationConstant.HinhThucBanHang.values());
        model.addAttribute("size", hoaDonResponsePageActive.getSize());
        model.addAttribute("totalPages", hoaDonResponsePageActive.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listHoaDon", hoaDonResponsePageActive);

        return "admin/hoa_don/hoa_don";
    }

    @GetMapping("/loadTrangThaiHd/{pageNo}")
    public String pageLoadTrangThaiHoaDon(@PathVariable("pageNo") Integer pageNo, @RequestParam(name = "selectedTrangThai", required = false) ApplicationConstant.TrangThaiHoaDon selectedTrangThai, Model model) {
        Page<HoaDonResponse> hoaDonResponsePageActive = hoaDonService.pageComboboxTrangThaiHoaDon(pageNo, 10,selectedTrangThai);

        // Định dạng tiền tệ Việt Nam
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        for (HoaDonResponse hd : hoaDonResponsePageActive) {
            BigDecimal thanhTien = hd.getThanhTien();
            String formattedThanhTien = currencyFormat.format(thanhTien);
            hd.setFormattedThanhTien((formattedThanhTien));
        }
        model.addAttribute("trangThaiHD", ApplicationConstant.TrangThaiHoaDon.values());
        model.addAttribute("trangThaiBH", ApplicationConstant.HinhThucBanHang.values());
        model.addAttribute("size", hoaDonResponsePageActive.getSize());
        model.addAttribute("totalPages", hoaDonResponsePageActive.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listHoaDon", hoaDonResponsePageActive);

        return "admin/hoa_don/hoa_don";
    }

    // hoa don cho
    @GetMapping("/detail-hoa-don/{id}")
    public String hoaDonChiTiet(@PathVariable("id") Integer id, Model model) {

        List<HoaDonChiTietResponse> hoaDonChiTietList = hoaDonService.getAllHoaDonChiTiet(id);
        HoaDonResponse hoaDonResponse = hoaDonService.getDetailHoaDon(id);

        // tinh tong tien
        BigDecimal totalAmount = hoaDonChiTietList.stream().map(HoaDonChiTietResponse::getDonGia).reduce(BigDecimal.ZERO, BigDecimal::add);

        model.addAttribute("totalAmount", totalAmount);
        List<HoaDonChiTietResponse> listGioHang = hoaDonService.getAllHoaDonChiTiet(id);
        model.addAttribute("hoaDon", hoaDonResponse);
        model.addAttribute("listHoaDonCho", hoaDonService.getAllHoaDonCho());
        model.addAttribute("listGioHang", listGioHang);
        model.addAttribute("listCtsp", chiTietSanPhamService.getAllChiTietSanPham());
        model.addAttribute("listKhachHang", khachHangService.getAllKhachHangActive());
        model.addAttribute("phuongThucThanhToan", ApplicationConstant.HinhThucThanhToan.values());
        model.addAttribute("listVoucher", hoaDonService.getAllViVoucher(hoaDonResponse.getKhachHang()));
        return "admin/hoa_don/hoa_don_chi_tiet";
    }

    @GetMapping("/delete-san-pham/{id}")
    public String deteleSanPhamInHoaDonChiTiet(@PathVariable("id") Integer id, Model model) {
        Integer idHd = hoaDonService.getOneHdct(id).getHoaDon().getId();
        hoaDonService.deleteById(id);
        return "redirect:/admin/psg/hoa-don/detail-hoa-don/" + idHd;
    }

    // lich su hoa don
    @GetMapping("/lich-su-hoa-don/{idHd}")
    public String lichSuHoaDon(@PathVariable("idHd") Integer idHd, Model model) {
        HoaDonResponse hoaDonResponse = hoaDonService.getDetailHoaDon(idHd);
        model.addAttribute("hoaDon", hoaDonResponse);
        System.out.println(hoaDonResponse.getTrangThai());
        switch (hoaDonResponse.getTrangThai()) {
            case PENDING:
                model.addAttribute("showConfirmButton", true);
                break;
            case CONFIRMED:
                model.addAttribute("showShippingButton", true);
                break;
            case SHIPPING:
                model.addAttribute("showCompleteButton", true);
                break;
            // và cứ thế cho các trạng thái khác
        }

        model.addAttribute("listLichSuHoaDon", hoaDonService.getAllLichSuHoaDon(idHd));
        model.addAttribute("listGiaoDich", hoaDonService.getAllGiaoDich(idHd));
        model.addAttribute("listHoaDonChiTiet", hoaDonService.getAllHoaDonChiTiet(idHd));
        model.addAttribute("trangThaiHoaDon", hoaDonResponse.getTrangThai());
        return "admin/hoa_don/lich_su_hoa_don";
    }

    // tao hoa don cho
    @PostMapping("/add-hoa-don-cho")
    public String addHoaDonCho() {
        return "redirect:/admin/psg/hoa-don/detail-hoa-don/"+hoaDonService.addHoaDon().getId();
    }

    // them san pham vao hoa do chi tiet
    @PostMapping("/add-hoa-don-chi-tiet/{idHd}/{idCtsp}")
    public String addHoaDonChiTiet(@PathVariable("idHd") Integer idHd, @PathVariable("idCtsp") Integer idCtsp) {
        hoaDonService.addHoaDonChiTiet(idCtsp, idHd);
        return "redirect:/admin/psg/hoa-don/detail-hoa-don/" + idHd;
    }

    // update số lượng sản phẩm và đơn giá
    @GetMapping("/update-quantity/{idHdct}/{newQuantity}")
    public String updateQuantity(@PathVariable("idHdct") Integer idHdct, @PathVariable("newQuantity") Integer newQuantity) {
        if (newQuantity > 0) {
            hoaDonService.updateHoaDonChiTietQuantity(idHdct, newQuantity);
        } else {
            // neu so luong trong hdct == 0 thì sẽ xóa sản phẩm
            hoaDonService.deleteById(idHdct);
        }
        return "redirect:/admin/psg/hoa-don/detail-hoa-don/" + hoaDonService.getOneHdct(idHdct).getHoaDon().getId();
    }

    // update khach hang cho hoa don
    @PostMapping("/update-hoa-don/khach-hang/{hoaDonId}")
    public String updateHoaDonWithKhachHang(@PathVariable("hoaDonId") Integer hoaDonId, @RequestParam("customerId") Integer customerId) {
        hoaDonService.updateHoaDonWithKhachHang(hoaDonId, customerId);
        return "redirect:/admin/psg/hoa-don/detail-hoa-don/" + hoaDonId;
    }

    @GetMapping("/searchHoaDon/{pageNo}")
    public String searchHoaDon(@PathVariable("pageNo") Integer pageNo, Model model, @RequestParam("pathSearch") String search) {
        Page<HoaDonResponse> hoaDonResponsePageActive = hoaDonService.pageSearchHoaDon(pageNo, 10, search);

        // Định dạng tiền tệ Việt Nam
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        for (HoaDonResponse hd : hoaDonResponsePageActive) {
            BigDecimal thanhTien = hd.getThanhTien();
            String formattedThanhTien = currencyFormat.format(thanhTien);
            hd.setFormattedThanhTien((formattedThanhTien));
        }

        model.addAttribute("size", hoaDonResponsePageActive.getSize());
        model.addAttribute("totalPages", hoaDonResponsePageActive.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listHoaDon", hoaDonResponsePageActive);

        return "admin/hoa_don/hoa_don";
    }

    @GetMapping("/searchDate/{pageNo}")
    public String searchDate(@PathVariable("pageNo") Integer pageNo, Model model, @RequestParam(value = "beginDate", required = false) LocalDate beginDate
            , @RequestParam(value = "endDate", required = false) LocalDate endDate) {
        Page<HoaDonResponse> hoaDonResponsePageActive = hoaDonService.pageSearchHoaDonBetweenDates(pageNo, 10, beginDate, endDate);

        // Định dạng tiền tệ Việt Nam
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        for (HoaDonResponse hd : hoaDonResponsePageActive) {
            BigDecimal thanhTien = hd.getThanhTien();
            String formattedThanhTien = currencyFormat.format(thanhTien);
            hd.setFormattedThanhTien((formattedThanhTien));
        }

        model.addAttribute("size", hoaDonResponsePageActive.getSize());
        model.addAttribute("totalPages", hoaDonResponsePageActive.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listHoaDon", hoaDonResponsePageActive);

        return "admin/hoa_don/hoa_don";
    }

    @GetMapping("/update-trang-thai-hoa-don/{id}/{trangThaiHoaDon}")
    public String updateTrangThaiHoaDon(@PathVariable("id") Integer idhd, @PathVariable("trangThaiHoaDon") ApplicationConstant.TrangThaiHoaDon trangThaiHoaDon) {
        hoaDonService.updateTrangThaiHoaDon(trangThaiHoaDon, idhd, "OK");
        return "redirect:/admin/psg/hoa-don/lich-su-hoa-don/" + idhd;
    }

    @PostMapping("/thanh-toan-hoa-don-tai-quay")
    public String thanhToanHoaDon(@ModelAttribute("hoaDon")UpdateHoaDonRequest updateHoaDonRequest,@RequestParam("hinhThucThanhToan")ApplicationConstant.HinhThucThanhToan hinhThucThanhToan) {
        if(updateHoaDonRequest.getHinhThucBanHang() == ApplicationConstant.HinhThucBanHang.INACTIVE){
            hoaDonService.thanhToanHoaDon(updateHoaDonRequest, ApplicationConstant.TrangThaiHoaDon.CONFIRMED,hinhThucThanhToan);
        }else {
            hoaDonService.thanhToanHoaDon(updateHoaDonRequest, ApplicationConstant.TrangThaiHoaDon.APPROVED,hinhThucThanhToan);
        }
        return "redirect:/admin/psg/hoa-don/lich-su-hoa-don/"+updateHoaDonRequest.getId();
    }
}
