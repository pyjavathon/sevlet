package hello.sevlet.domain.member;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {
	
	MemberRepository memberRepository = MemberRepository.getInstance();
	
	
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void save() {
		//given 주어졌을 때
		Member member = new Member("hello",20);
		
		//when 실행했을 때
		Member saveMember = memberRepository.save(member);
		
		//then 예상 결과
		Member findMember = memberRepository.findById(saveMember.getId());
		Assertions.assertThat(findMember).isEqualTo(saveMember);
	}
	
	@Test
	void findAll() {
		//given
		Member member1 = new Member("member1",20);
		Member member2 = new Member("member2",30);
		
		memberRepository.save(member1);
		memberRepository.save(member2);
		
		//when
		List<Member> result = memberRepository.findAll();
		
		//then
		Assertions.assertThat(result.size()).isEqualTo(2);
		Assertions.assertThat(result).contains(member1,member2);
	}
	
}
