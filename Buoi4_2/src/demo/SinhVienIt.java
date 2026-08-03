package demo;

public class SinhVienIt extends Student {
	private String nganh;

	public SinhVienIt(String name, String gPA, String nganh) {
		super(name, gPA);
		this.nganh = nganh;
	}

	public SinhVienIt() {
		super();
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	@Override
	public String toString() {
		return "SinhVienIt [nganh=" + nganh + ", toString()=" + super.toString() + "]";
	}

	@Override
	public String an() {
		return "san";
	}
}
