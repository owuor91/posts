package dev.owuor91.data.repositories

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import dev.owuor91.data.local.PostsDao
import dev.owuor91.data.local.PostsDatabase
import dev.owuor91.data.local.PostsDbModel
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class PostsDbRepositoryTest {
    lateinit var postsDao: PostsDao
    lateinit var postsDatabase: PostsDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        postsDatabase = Room.inMemoryDatabaseBuilder(context, PostsDatabase::class.java).build()
        postsDao = postsDatabase.postsDao()
    }

    @Test
    fun shouldFetchPosts() {
        val post = PostsDbModel(2, 2, "Post title 2", "Post body 2")
        postsDao.insertPost(post)
        assertThat(postsDao.getPosts().blockingGet()[0].body, equalTo("Post body 2"))
    }

    @Test
    fun shouldSavePost() {
        val post = PostsDbModel(1, 2, "Post title", "Post body")
        val post2 = PostsDbModel(2, 2, "Post title 2", "Post body 2")
        postsDao.insertPost(post)
        postsDao.insertPost(post2)
        val retrieve = postsDao.getPosts().blockingGet()
        assertEquals(retrieve.size, 2)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        postsDatabase.close()
    }
}