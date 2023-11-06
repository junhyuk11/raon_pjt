package com.arch.raon.domain.grammar.repository;

import com.arch.raon.domain.grammar.dto.query.GrammarMyRankQueryDTO;
import com.arch.raon.domain.grammar.entity.QGrammarScore;
import com.arch.raon.domain.member.entity.QMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomGrammarRepositoryImpl implements CustomGrammarRepository {

    private final JPAQueryFactory queryFactory;

    QMember qMember = QMember.member;
    QGrammarScore qGrammarScore = QGrammarScore.grammarScore;

    /**
     * score 전체 오름차순으로 정렬
     * @return
     */
    @Override
    public List<GrammarMyRankQueryDTO> findAllByCountry() {

        List<GrammarMyRankQueryDTO> rankResults = queryFactory
                .select(Projections.constructor(GrammarMyRankQueryDTO.class,
                    qMember.nickname,
                    qGrammarScore.score
                ))
                .from(qGrammarScore)
                .join(qGrammarScore.member, qMember)
                .orderBy(qGrammarScore.score.asc())
                .fetch();

        return rankResults;
    }
}
