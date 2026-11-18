package entity;

import java.text.DecimalFormat;

import enums.HuongNha;

public abstract class BatDongSan {
	protected String maBatDongSan;
	protected String diaChi;
	protected double dienTich;
	protected HuongNha huongnha;
	protected double donGiaMoiM2;
	
	public BatDongSan() {
		this("", "", 0.0, HuongNha.DONG_TU_TRACH, 0.0);
	}
	
	public BatDongSan(String maBatDongSan, String diaChi, double dienTich, HuongNha huongnha, double donGiaMoiM2) {
		super();
		this.maBatDongSan = maBatDongSan;
		this.diaChi = diaChi;
		this.dienTich = dienTich;
		this.huongnha = huongnha;
		this.donGiaMoiM2 = donGiaMoiM2;
	}

	public String getMaBatDongSan() {
		return maBatDongSan;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public double getDienTich() {
		return dienTich;
	}

	public HuongNha getHuongnha() {
		return huongnha;
	}

	public double getDonGiaMoiM2() {
		return donGiaMoiM2;
	}

	public void setMaBatDongSan(String maBatDongSan) {
		if (maBatDongSan == null || maBatDongSan.isBlank()) {
			throw new RuntimeException("Ma bat dong san khong duoc rong!");
		}
		this.maBatDongSan = maBatDongSan;
	}

	public void setDiaChi(String diaChi) {
		if (diaChi == null || diaChi.isBlank()) {
			throw new RuntimeException("Dia chi khong duoc rong!");
		}
		this.diaChi = diaChi;
	}

	public void setDienTich(double dienTich) {
		if (dienTich <= 10.0) {
			throw new RuntimeException("Dien tich phai lon hon 10.0");
		}
		this.dienTich = dienTich;
	}

	public void setHuongnha(HuongNha huongnha) {
		if (huongnha != HuongNha.DONG_TU_TRACH && huongnha != HuongNha.TAY_TU_TRACH) {
			throw new RuntimeException("Huong nha khong hop le");
		}
		this.huongnha = huongnha;
	}

	public void setDonGiaMoiM2(double donGiaMoiM2) {
		if (donGiaMoiM2 <= 0) {
			throw new RuntimeException("Don gia moi m2 phai lon hon 0.0");
		}
		this.donGiaMoiM2 = donGiaMoiM2;
	}
	
	public abstract double tinhGiaTriGiaoDich();

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return String.format("| %15s | %15s | %15s | %15s | %15s | %15s | ", maBatDongSan, diaChi, dienTich, huongnha, df.format(donGiaMoiM2), df.format(tinhGiaTriGiaoDich()));
	}
	
	
}
