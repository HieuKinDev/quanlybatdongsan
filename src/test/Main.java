package test;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import entity.CanHoChungCu;
import entity.DanhSachBatDongSan;
import entity.NhaPho;
import enums.HuongNha;
import enums.LoaiMatTien;
import enums.ViTriTang;

public class Main {
	public static void main(String[] args) {
		DanhSachBatDongSan ds = new DanhSachBatDongSan(List.of(
				new CanHoChungCu("CC01", "123 HCM", 2000, HuongNha.DONG_TU_TRACH, 100000000.0, ViTriTang.TANG_CAO),
				new CanHoChungCu("CC02", "321 CT", 1000, HuongNha.TAY_TU_TRACH, 20000000.0, ViTriTang.TANG_THAP),
				new NhaPho("P01", "345 DN", 150, HuongNha.TAY_TU_TRACH, 3000000.0, LocalDate.of(2026, 12, 12), LoaiMatTien.DUONG_NOI_BO),
				new NhaPho("P02", "543 HN", 250, HuongNha.DONG_TU_TRACH, 5000000.0, LocalDate.of(2026, 12, 20), LoaiMatTien.MAT_TIEN_LON),
				new NhaPho("P03", "345 KH", 100, HuongNha.TAY_TU_TRACH, 2500000.0, LocalDate.of(2026, 12, 1), LoaiMatTien.HEM_NHO)
				));
		
		// 1. Kiem thu themBDS
		// Trung ma
		System.out.println(" Kiem thu them BDS");
		if (ds.themBDS(new CanHoChungCu("CC01", "111 HCM", 2000, HuongNha.DONG_TU_TRACH, 100000000.0, ViTriTang.TANG_CAO))) {
			System.out.println("Them thanh cong!");
		} else {
			System.out.println("Them khong thanh cong - Trung ma");
		}
		
		// Hop le
		if (ds.themBDS(new NhaPho("P04", "345 KH", 100, HuongNha.TAY_TU_TRACH, 2500000.0, LocalDate.of(2026, 12, 1), LoaiMatTien.HEM_NHO))) {
			System.out.println("Them thanh cong!");
		}
		
		System.out.println();
		
		// 2. Kiem thu sap xep
		System.out.println(" Danh sach sau khi sap xep");
		ds.sapGiamDanTheoDienTich();
		System.out.println(ds);
		
		System.out.println();
		
		// 3. Kiem thu xuat danh sach cao oc tang cao
		System.out.println(" Danh sach cao oc tang cao");
		System.out.println(ds.xuatDSCaoOcTangCao());
		
		System.out.println();
		
		// 4. Kiem thu thong ke
		System.out.println(" Thong ke tong gia tri giao dich cua tung loai bat dong san");
		Map<String, Double> danhSachThongKe = ds.thongKeTongGiaTriTheoTungLoai();
		for (Map.Entry<String, Double> entry : danhSachThongKe.entrySet()) {
			DecimalFormat df = new DecimalFormat("#,##0");
			System.out.println(String.format("Bat dong san: %-15s | Tong gia tri giao dich: %-15s", entry.getKey(), df.format(entry.getValue())));
		}
		
	}
}
