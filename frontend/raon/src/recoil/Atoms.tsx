import { atom } from 'recoil';

export const submitState = atom<string[]>({
  key: 'submitState',
  default: [],
});

export const answerState = atom<string[]>({
  key: 'answerState',
  default: [],
});

export const spellingIdState = atom<number[]>({
  key: 'spellingIdState',
  default: [],
});

export const summarizeState = atom({
  key: 'summarizeState',
  default: {
    topic: '',
    title: '',
    content: '',
    summarize_content: '',
  },
});

export const dictScoreState = atom<number>({
  key: 'dictScoreState',
  default: 0,
});

export const multiDictState = atom({
  key: 'multiDictState',
  default: {
    type: '',
    id: '',
    word: '',
    initial: '',
    meaning: '',
    west_word: '',
    north_word: '',
    east_word: '',
    south_word: '',
    answer: ''
  }
})