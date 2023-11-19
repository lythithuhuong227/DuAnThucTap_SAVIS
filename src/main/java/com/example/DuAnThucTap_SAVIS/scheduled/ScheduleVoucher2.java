package com.example.DuAnThucTap_SAVIS.schedule;

import com.example.DuAnThucTap_SAVIS.common.ApplicationConstant;
import com.example.DuAnThucTap_SAVIS.entity.VoucherThuHang;
import com.example.DuAnThucTap_SAVIS.repository.VoucherThuHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component

public class ScheduleVoucher2 {
    @Autowired
    private VoucherThuHangRepository voucherThuHangRepository;

    @Scheduled(fixedRate = 1000)
    public void updateVoucherStatus(){
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<VoucherThuHang> pendingVouchers = voucherThuHangRepository.findByNgayBatDauIsBeforeAndTrangThai(currentDateTime, ApplicationConstant.TrangThaiVoucher.PENDING);

        for (VoucherThuHang voucher : pendingVouchers) {
            voucher.setTrangThai(ApplicationConstant.TrangThaiVoucher.ACTIVE);
        }

        voucherThuHangRepository.saveAll(pendingVouchers);
    }

}
