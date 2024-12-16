package com.example.pot

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "MyDatabase.db"
        private const val DATABASE_VERSION = 3 // 데이터베이스 버전 증가

        // 테이블 및 컬럼 이름 정의
        const val TABLE_EXERCISE = "ExerciseNotes"
        const val TABLE_TAXI = "TaxiNotes"
        const val TABLE_STUDY = "StudyNotes"
        const val TABLE_MEAL = "MealNotes"
        const val COLUMN_ID = "id"
        const val COLUMN_TEXT = "text"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // ExerciseNotes 테이블 생성 쿼리
        val createExerciseTableQuery = """
            CREATE TABLE $TABLE_EXERCISE (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TEXT TEXT
            )
        """
        // TaxiNotes 테이블 생성 쿼리
        val createTaxiTableQuery = """
            CREATE TABLE $TABLE_TAXI (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TEXT TEXT
            )
        """
        // StudyNotes 테이블 생성 쿼리
        val createStudyTableQuery = """
            CREATE TABLE $TABLE_STUDY(
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TEXT TEXT
            )
        """
        // MealNotes 테이블 생성 쿼리
        val createMealTableQuery = """
            CREATE TABLE $TABLE_MEAL(
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TEXT TEXT
            )
        """
        db?.execSQL(createExerciseTableQuery)
        db?.execSQL(createTaxiTableQuery)
        db?.execSQL(createStudyTableQuery)
        db?.execSQL(createMealTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // 기존 테이블 삭제 후 다시 생성
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_EXERCISE")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TAXI")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_STUDY")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_TAXI")
        onCreate(db)
    }

    // 데이터 삽입 메서드
    fun insertData(text: String, tableName: String): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TEXT, text)

        val result = db.insert(tableName, null, values)
        db.close()
        return result != -1L
    }

    // 데이터 조회 메서드
    fun getAllData(tableName: String): List<String> {
        val db = readableDatabase
        val cursor = db.query(tableName, arrayOf(COLUMN_TEXT), null, null, null, null, null)
        val dataList = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                dataList.add(getString(getColumnIndexOrThrow(COLUMN_TEXT)))
            }
            close()
        }
        return dataList
    }
}
