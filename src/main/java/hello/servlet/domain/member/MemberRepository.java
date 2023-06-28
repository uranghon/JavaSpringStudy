package hello.servlet.domain.member;


import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    /**
     * 싱글톤이라서 사실 얘들 static으로 할 필요가 없긴 함. 어짜피 싱글톤 객체 가져다 쓸거니까
     * static 은 서로 다른 객체들이 서로 공유할 변수를 위한 선언이라
     *
     * 아래처럼 해도 된다는 뜻
     * private Map<Long, Member> store = new HashMap<>();
     * private long sequence = 0L;
     */
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    /**
     * 싱글톤으로 만드는거
     * 다른데서 쓰고싶으면 얘로 쓰자
     */
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤으로 만들거라 생성자를 private 으로 해서 막음
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
