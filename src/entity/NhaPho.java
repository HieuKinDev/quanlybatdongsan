package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import enums.HuongNha;
import enums.LoaiMatTien;

public class NhaPho extends BatDongSan {
	private LocalDate ngayBanGiao;
	private LoaiMatTien loaiMatTien;
	
	public NhaPho() {
		this("", "", 0.0, HuongNha.DONG_TU_TRACH, 0.0, LocalDate.now(), LoaiMatTien.HEM_NHO);
	}
	
	public NhaPho(String maBatDongSan, String diaChi, double dienTich, HuongNha huongnha, double donGiaMoiM2,
			LocalDate ngayBanGiao, LoaiMatTien loaiMatTien) {
		super(maBatDongSan, diaChi, dienTich, huongnha, donGiaMoiM2);
		this.ngayBanGiao = ngayBanGiao;
		this.loaiMatTien = loaiMatTien;
	}

	public LocalDate getNgayBanGiao() {
		return ngayBanGiao;
	}

	public LoaiMatTien getLoaiMatTien() {
		return loaiMatTien;
	}

	public void setNgayBanGiao(LocalDate ngayBanGiao) {
		if (ngayBanGiao.isBefore(LocalDate.now())) {
			throw new RuntimeException("Ngay ban giao phai sau ngay hien hanh");
		}
		this.ngayBanGiao = ngayBanGiao;
	}

	public void setLoaiMatTien(LoaiMatTien loaiMatTien) {
		if (loaiMatTien != LoaiMatTien.HEM_NHO && loaiMatTien != LoaiMatTien.DUONG_NOI_BO && loaiMatTien != LoaiMatTien.MAT_TIEN_LON) {
			throw new RuntimeException("Loai mat tien khong hop le");
		}
		this.loaiMatTien = loaiMatTien;
	}

	@Override
	public double tinhGiaTriGiaoDich() {
		double giaTriGoc = getDienTich() * getDonGiaMoiM2();
		double heSoViTri = 0.0;
		
		if (loaiMatTien.equals(LoaiMatTien.MAT_TIEN_LON)) {
			heSoViTri = giaTriGoc * 0.3;
		} else {
			heSoViTri = giaTriGoc * 0.1;
		}
		
		return giaTriGoc + heSoViTri;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
		return super.toString() + String.format("%15s | %15s | ", ngayBanGiao.format(dtf), loaiMatTien);
	}
	
}
