package entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import enums.ViTriTang;

public class DanhSachBatDongSan {
	List<BatDongSan> danhSach;
	
	public DanhSachBatDongSan() {
		this.danhSach = new ArrayList<BatDongSan>();
	}

	public DanhSachBatDongSan(List<BatDongSan> danhSach) {
		this.danhSach = new ArrayList<BatDongSan>(danhSach);
	}
	
	public boolean themBDS(BatDongSan bds) {
		if (bds == null) {
			throw new RuntimeException("Bat dong san khong hop le!");
		}
		
		if (danhSach.contains(bds)) {
			return false;
		}
		
		return danhSach.add(bds);
	}
	
	public void sapGiamDanTheoDienTich() {
		danhSach.sort(Comparator.comparing(BatDongSan::getDienTich).reversed());
	}
	
	public String xuatDSCaoOcTangCao() {
		StringBuilder sb = new StringBuilder();
		for (BatDongSan bds : danhSach) {
			if (bds instanceof CanHoChungCu) {
				if (((CanHoChungCu) bds).getViTriTang().equals(ViTriTang.TANG_CAO)) {
					sb.append(bds).append("\n");
				}
			}
		}
		
		return sb.toString();
	}
	
	public Map<String, Double> thongKeTongGiaTriTheoTungLoai() {
		return danhSach.stream().collect(Collectors.groupingBy(bds -> bds.getClass().getSimpleName(), Collectors.summingDouble(BatDongSan::tinhGiaTriGiaoDich)));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (BatDongSan bds : danhSach) {
			sb.append(bds).append("\n");
		}
		
		return sb.toString();
	}
	
	

}
