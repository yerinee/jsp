package kr.or.ddit.member.model;

import java.util.Date;

public class MemberVO {
	private String userId;
	private String pass;
	private String usernm;
	private String alias;
	private Date reg_dt;
	private String addr1;
	private String addr2;
	private String zipcode;
	private String filename;
	private String realfilename;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getRealfilename() {
		return realfilename;
	}
	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", pass=" + pass + ", usernm=" + usernm + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realfilename=" + realfilename + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr1 == null) ? 0 : addr1.hashCode());
		result = prime * result + ((addr2 == null) ? 0 : addr2.hashCode());
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((realfilename == null) ? 0 : realfilename.hashCode());
		result = prime * result + ((reg_dt == null) ? 0 : reg_dt.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((usernm == null) ? 0 : usernm.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (addr1 == null) {
			if (other.addr1 != null)
				return false;
		} else if (!addr1.equals(other.addr1))
			return false;
		if (addr2 == null) {
			if (other.addr2 != null)
				return false;
		} else if (!addr2.equals(other.addr2))
			return false;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (realfilename == null) {
			if (other.realfilename != null)
				return false;
		} else if (!realfilename.equals(other.realfilename))
			return false;
		if (reg_dt == null) {
			if (other.reg_dt != null)
				return false;
		} else if (!reg_dt.equals(other.reg_dt))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (usernm == null) {
			if (other.usernm != null)
				return false;
		} else if (!usernm.equals(other.usernm))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	
	
	
	
	
	
}
