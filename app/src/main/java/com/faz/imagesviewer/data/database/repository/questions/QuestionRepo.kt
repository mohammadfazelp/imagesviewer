package com.faz.imagesviewer.data.database.repository.questions

import com.faz.imagesviewer.data.database.repository.questions.Question
import io.reactivex.Observable

interface QuestionRepo {

    fun isQuestionsRepoEmpty(): Observable<Boolean>

    fun insertQuestions(questions: List<Question>): Observable<Boolean>

    fun loadQuestions(): Observable<List<Question>>
}