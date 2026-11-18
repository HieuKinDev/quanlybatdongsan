package entity;

import enums.HuongNha;
import enums.ViTriTang;

public class CanHoChungCu extends BatDongSan {
	private ViTriTang viTriTang;
	
	public CanHoChungCu() {
		this("", "", 0.0, HuongNha.DONG_TU_TRACH, 0.0, ViTriTang.TANG_THAP);
	}

	public CanHoChungCu(String maBatDongSan, String diaChi, double dienTich, HuongNha huongnha, double donGiaMoiM2,
			ViTriTang viTriTang) {
		super(maBatDongSan, diaChi, dienTich, huongnha, donGiaMoiM2);
		this.viTriTang = viTriTang;
	}

	public ViTriTang getViTriTang() {
		return viTriTang;
	}

	public void setViTriTang(ViTriTang viTriTang) {
		if (viTriTang != ViTriTang.TANG_THAP && viTriTang != ViTriTang.TANG_CAO && viTriTang != ViTriTang.TANG_TRUNG) {
			throw new RuntimeException("Vi tri tang khong hop le");
		}
		this.viTriTang = viTriTang;
	}

	@Override
	public double tinhGiaTriGiaoDich() {
		double giaTriGoc = getDienTich() * getDonGiaMoiM2();
		double phiView = 0.0;
		if (viTriTang.equals(ViTriTang.TANG_CAO)) {
			phiView = giaTriGoc * 0.15;
		} else {
			phiView = giaTriGoc * 0.05;
		}
		
		return giaTriGoc + phiView;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%15s | ", viTriTang);
	}
	
}
