

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import emp.EmpDataSet;
import emp.EmpVO;
import emp.Login;

public class EmpMain {
	Scanner scan = new Scanner(System.in);
	public EmpMain() {

	}
	public void start() {
		//아이디와 비밀번호를 입력받아 로그인 구현하기
		Login.id = conInput("아이디");
		Login.pwd = conInput("비밀번호");
		if(Login.loginCheck()) {//로그인 성공시
			//초기데이터 세팅
			EmpDataSet.setEmpList();
			do {
				String menu = conInput("메뉴[1.사원전체목록 , 2.사원등록 , 3.사원수정 , 4.사원삭제 , 5.종료]");
				if(menu.equals("5")) {
					break;
				//사원목록	
				}else if(menu.equals("2")) {
					empInsert();
				//사원수정
				}else if(menu.equals("3")) {
					empEdit();
				//사원삭제
				}else if(menu.equals("4")) {
					empDel();
				//사원목록
				}
				empOutput();
				
			}while(true);
		}else {//로그인 실패시
			System.out.println("로그인 실패하였습니다.");
			start();
		}
	}
	
	//사원삭제
	public void empDel() {
		String empName = conInput("삭제할 사원명");
		EmpDataSet.empList.remove(empName);
	}
	
	
	
	
	
	//사원수정
	public void empEdit() {
		//사원명 입력
		String empName = conInput("수정할 사원명을 입력하세요.");
		
		
		EmpVO vo = EmpDataSet.empList.get(empName);
		if(vo==null) {//입력한 사원의 정보가 없을때
			System.out.println("존재하지 않는 사원명입니다.");
		}else {//연락처 , 부서명 , 직급
			String subMenu = conInput("수정할 정보를 선택하세요[1.연락처 , 2.부서명 , 3.직급");
			if(subMenu.equals("1")) {//연락처 수정
				String tel = conInput("수정할 연락처를 입력하세요.");
				vo.setTel(tel);
			}else if(subMenu.equals("2")) {//부서명 수정
				String depart = conInput("수정할 부서명을 입력하세요.");
				vo.setDepart(depart);
			}else if(subMenu.equals("3")) {//직급 수정
				String position = conInput("수정할 직급을 입력하세요.");
				vo.setDepart(position);
			}	
		}
	}
	
	
	
	//사원등록
	public void empInsert() {
		int no = Integer.parseInt(conInput("사원번호"));
		String name = conInput("사원명");
		String tel = conInput("연락처");
		String depart = conInput("부서명");
		String position = conInput("직급");

		EmpDataSet.empList.put(name, new EmpVO(no,name,tel,depart,position));
	}
	
	//사원전체 목록 출력
	public void empOutput() {
		Set<String> keyList = EmpDataSet.empList.keySet();
		Iterator<String> ii = keyList.iterator();
		while (ii.hasNext()) {
			EmpVO vo = EmpDataSet.empList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\n",vo.getEmpNo(),vo.getEmpName(),vo.getTel(),vo.getDepart(),vo.getPosition());
		}
	}
	
	//콘솔에서 문자입력 받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg+"=");
		return scan.nextLine();
	}
	
	//main메소드
	public static void main(String[] args) {
		new EmpMain().start();
		System.out.println("프로그램이 종료되었습니다.");
	}

}
