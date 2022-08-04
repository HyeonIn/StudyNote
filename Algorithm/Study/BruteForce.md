## Brute-force

### 완전 검색

- 문제의 해법으로 생각할 수 있는 모든 경우의 수를 나열해보고 확인하는 기법

#### 특징

- 모든 경우의 수를 테스트한 후, 최종 해법을 도출
- 상대적으로 빠른 시간에 문제 해결을 할 수 있음
- 일반적으로 경우의 수가 작을 때 유용

<hr>

#### 순열(Permutation)

- 서로 다른 n개의 원소 중 r개를 뽑아서 한 줄로 나열하는 것

##### 표현과 계산

- nPr : 서로 다른 n개 중 r개를 선택하는 순열
- nPr = n * (n-1) * (n-2) * ... * (n-r+1)
  - nPn = n! (Factorial)
- n > 12 일 때 시간 복잡도 폭발적 상승

##### 구현

A,B,C,D 카드 네 장 중에 2장을 뽑는 모든 경우 출력(순서 상관 있음)
``` java
public class CardPermutation {
	static boolean[] used; // 사용 중인 카드 체크
	static String[] cards; // 순열에 사용되는 재료
	static String[] result; // 현재 카드 상황
	
	public static void main(String[] args) {
		cards = new String[4];
		cards[0] = "A";
		cards[1] = "B";
		cards[2] = "C";
		cards[3] = "D";
		
		result = new String[2];
		used = new boolean[4];
		
		perm(0);
	}
	
	public static void perm(int idx) {
		if(idx==result.length) {
			// 카드가 다 채워졌으면 출력
			System.out.println(Arrays.toString(result));
			return; //재귀 기저조건
		}
		
		for(int i=0; i<cards.length; i++) {
			if(used[i]==true) continue; // 이미 사용중인 카드는 건너뛰기.
			
			result[idx] = cards[i]; // idx번 자리에 카드 놓기
			used[i] = true; // 사용중인 카드 표시
			perm(idx+1); // 다음 자리 카드 채우기
			used[i] = false; //카드 사용중 아니라고 표시 
		}
	}
}
```

<hr>

#### 조합(Combination)

- 서로 다른 n개의 원소 중 r개를 순서 없이 골라낸 것

##### 표현과 계산

- nCr : 서로 다른 n개 중 r개를 선택하는 조합
- nCr = n! / (n-r)! * r! (n>=r)
  - nCr = n-1Cr-1 + n-1Cr : 재귀적 접근 가능!
  - nC0 = 1


##### 구현

A,B,C 카드 세 장 중에 2장을 뽑는 모든 경우 출력(순서 상관 없음)
``` java
public class CardCombination {
	static String[] cards = {"A","B","C"};
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		comb(0, 0);
	}
	
	static void comb(int idx, int cnt) {
		if(cnt==2) { // 2장 다 뽑혔을 때
			System.out.print("지금 만들어진 조합 : { ");
			for(int i=0; i<cards.length; i++) { // 어떤 카드들이 선택 되어있는지 반복으로 확인
				if(select[i])
					System.out.print(cards[i]+" "); 
			}
			System.out.println("}");
			return; //재귀 기저조건
		}
		if(idx == cards.length) return; // 재귀 기저조건
		
		select[idx] = true; // 카드 고르기
		comb(idx+1, cnt+1); // 다음 카드 고르기
		select[idx] = false; // 고른 카드 내려놓기
		comb(idx+1, cnt); // 다음 카드 부터 다시 고르기 시작
	}
}

```

##### 순열? 조합?   

- 순열과 조합이 헷갈릴 때에는 뽑힌 순서를 고려하는 지 확인!
  - 순서를 고려하면, **순열**
  - 순서를 고려하지 않으면, **조합**
  
#### 부분 집합(Power Set)

- 집합에 포함된 원소들을 선택하는 것

##### 부분집합의 수 계산

- 원소가 n개일 때, 공집합을 포함한 부분집합의 수는 2^n개
  - 이는 각 원소를 부분집합에 포함 시키거나 포함 시키지 않는 2가지 경우를 모든 원소에 적용한 경우의 수와 같다.
  - ex) {1,2,3,4} : 2 * 2 * 2 * 2 = 2^4 = 16
  
##### 구현

- 3장의 카드 A,B,C로 만들 수 있는 모든 부분 집합 출력
``` java
public class CardPowerSet {
	static String[] cards = {"A","B","C"};
	static boolean[] select = new boolean[cards.length];
	
	public static void main(String[] args) {
		powerset(0);
	}
	
	static void powerset(int idx) {
		if(idx == cards.length) {
			System.out.print("지금 만들어진 부분집합 : { ");
			for(int i=0; i<cards.length; i++) {
				if(select[i])
					System.out.print(cards[i]+" ");
			}
			System.out.println("}");
			return;
		}
		
		select[idx] = true;
		powerset(idx+1);
		select[idx] = false;
		powerset(idx+1);
	}
}

```
