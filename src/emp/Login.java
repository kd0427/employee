package emp;

public class Login {
	public static String id;
	public static String pwd;
	public Login() {}
	//로그인 체크 하는 메소드 (true:성공 , false: 실패)
	public static boolean loginCheck() {
		if(id == "" || pwd == "") {
			System.out.println("비밀번호를 입력 후 로그인 하세요.");
			return false;
		}
		if(id.equals("master") && pwd.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}

}
