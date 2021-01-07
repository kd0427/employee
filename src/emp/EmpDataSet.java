package emp;

import java.util.HashMap;


public class EmpDataSet {
	public static HashMap<String,EmpVO> empList = new HashMap<String,EmpVO>();
	public EmpDataSet() {
	}
	public static void setEmpList()	{
		empList.put("홍길동", new EmpVO(1,"홍길동", "02-1234-1111","총무부","과장"));
		empList.put("강감찬", new EmpVO(3,"강감찬","02-5689-9898","기획부","대리"));
		empList.put("유승룡", new EmpVO(5,"유승룡","02-2356-2423","총무부","사원"));
		empList.put("이순신", new EmpVO(2,"이순신","02-2323-3433","인사부","사원"));
		empList.put("장영실", new EmpVO(4,"장영실","02-3599-5555","영업부","부장"));
	}

}
