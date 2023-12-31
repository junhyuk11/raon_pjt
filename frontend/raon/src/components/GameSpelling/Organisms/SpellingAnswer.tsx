import React, { useEffect } from 'react';
import styled from 'styled-components';
import { useRecoilValue } from 'recoil';
import { useNavigate } from 'react-router';
import { postSpellingResult } from '../../../api/GameSpellingApi.tsx';
import {
  submitState,
  answerState,
  spellingIdState,
} from '../../../recoil/Atoms.tsx';
import ExitButton from '../../Common/Atoms/ExitButtonInRoom.tsx';

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const ScoreHeader = styled.h1`
  font-family: 'CookieRun';
  text-align: center;
  font-size: 4.375rem;
  width: 100%;
  margin-top: 1.5rem;
  margin-bottom: 2rem;
  color: white;
`;

const Content = styled.div`
  font-family: 'CookieRun';
  font-size: 3.125rem;
  color: white;
`;

const Columns = styled.div`
  display: flex;
  justify-content: center;
  gap: 3.125rem;
`;

const Column = styled.div`
  display: flex;
  flex-direction: column;
`;

const IncorrectAnswer = styled.span`
  text-decoration: line-through;
  margin-right: 2.5rem;
`;

const CorrectAnswer = styled.span`
  color: red;
`;

const SpellingAnswer = () => {
  const userAnswers = useRecoilValue(submitState);
  const correctAnswers = useRecoilValue(answerState);
  const spellingId = useRecoilValue(spellingIdState);
  const navigate = useNavigate();

  const leftAnswers = userAnswers.slice(0, 5);
  const rightAnswers = userAnswers.slice(5, 10);

  const score = userAnswers.reduce((acc, answer, index) => {
    return answer === correctAnswers[index] ? acc + 1 : acc;
  }, 0);

  const resultsData = spellingId.map((id, index) => ({
    id,
    hit: userAnswers[index] === correctAnswers[index] ? 1 : 0,
  }));

  useEffect(() => {
    const sendResults = async () => {
      try {
        const response = await postSpellingResult({
          grammarResultList: resultsData,
        });
        console.log('결과를 성공적으로 보냈습니다.', response);
      } catch (error) {
        console.error('결과 전송에 실패했습니다.', error);
      }
    };

    sendResults();
  }, []);

  return (
    <Container>
      <ScoreHeader>
        당신의 점수:
        <CorrectAnswer> {score * 10}</CorrectAnswer> 점
      </ScoreHeader>
      <Content>
        <Columns>
          <Column>
            {leftAnswers.map((answer, index) => (
              /* eslint-disable-next-line react/no-array-index-key */
              <div key={index}>
                {index + 1}.{' '}
                {answer === correctAnswers[index] ? (
                  answer
                ) : (
                  <>
                    <IncorrectAnswer>{answer}</IncorrectAnswer>
                    <CorrectAnswer>{correctAnswers[index]}</CorrectAnswer>
                  </>
                )}
              </div>
            ))}
          </Column>
          <Column>
            {rightAnswers.map((answer, index) => (
              /* eslint-disable-next-line react/no-array-index-key */
              <div key={index + 5}>
                {index + 6}.{' '}
                {answer === correctAnswers[index + 5] ? (
                  answer
                ) : (
                  <>
                    <IncorrectAnswer>{answer}</IncorrectAnswer>
                    <CorrectAnswer>{correctAnswers[index + 5]}</CorrectAnswer>
                  </>
                )}
              </div>
            ))}
          </Column>
        </Columns>
      </Content>
      <ExitButton
        onClick={() => {
          navigate('/main');
        }}
      />
    </Container>
  );
};

export default SpellingAnswer;
