package hello.core.discount;

import hello.core.member.Member;

// 할인정책 추상화
public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인금액
     */
    int discount(Member member, int price);
}
