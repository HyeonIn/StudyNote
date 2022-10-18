package aop_proxy;

public class PersonProxy implements Person {
	private Before before;
	private After after;
	private AfterReturning afterReturning;
	private AfterThrowing afterThrowing;
	private Person person;

	public void setBefore(Before before) {
		this.before = before;
	}

	public void setAfter(After after) {
		this.after = after;
	}

	public void setAfterReturning(AfterReturning afterReturning) {
		this.afterReturning = afterReturning;
	}

	public void setAfterThrowing(AfterThrowing afterThrowing) {
		this.afterThrowing = afterThrowing;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String lunch(int arg) throws Exception {
		String result = null;
		if (before != null)
			before.doBefore(); // before
		try {
			if (person != null)
				result = person.lunch(arg); // 핵심관심사항
			if (after != null)
				afterReturning.doAfterReturn(); // after returning
		} catch (Exception ex) {
			if (afterThrowing != null)
				afterThrowing.doAfterThrow(); // after throwing
			throw ex;
		} finally {
			if (after != null)
				after.doAfter();// after
		}
		return result;
	}
}
