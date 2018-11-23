package com.faz.imagesviewer.data.database.repository.questions

import io.reactivex.Observable
import javax.inject.Inject

class QuestionRepository @Inject internal constructor(private val questionsDao: QuestionsDao) : QuestionRepo {

    override fun isQuestionsRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ questionsDao.loadAll().isEmpty() })

    override fun insertQuestions(questions: List<Question>): Observable<Boolean> {
        questionsDao.insertAll(questions)
        return Observable.just(true)
    }

    override fun loadQuestions(): Observable<List<Question>> = Observable.fromCallable({ questionsDao.loadAll() })
}


