package org.hanbo.mvc.entities;

import org.apache.lucene.search.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class Sys_meta_questionRepository
{
   @Autowired
   private SessionFactory sessionFactory;

   @Transactional
   public void indexSys_meta_question() throws Exception
   {
      try
      {
         Session session = sessionFactory.getCurrentSession();
      
         FullTextSession fullTextSession = Search.getFullTextSession(session);
         fullTextSession.createIndexer().startAndWait();
      }
      catch(Exception e)
      {
         throw e;
      }
   }
   

   @Transactional
   public List<Sys_meta_question> searchForBook(String searchText) throws Exception
   {
      try
      {
         Session session = sessionFactory.getCurrentSession();
         
         FullTextSession fullTextSession = Search.getFullTextSession(session);


         QueryBuilder qBuilder = fullTextSession.getSearchFactory()
                 .buildQueryBuilder().forEntity(Sys_meta_question.class).get();
         Query query = new Query() {
             @Override
             public String toString(String s) {
                 return null;
             }
         };
         //can start logic
            query = qBuilder
             .keyword().wildcard().onField("QUESTION_TEXT")
             .matching("*"+searchText+"*")
             .createQuery();
         //////////

         /*

          query = qBuilder
           .keyword().onFields(new String[]{"QUESTION_ID", "QUESTION_CODE", "QUESTION_TEXT"})
           .matching(searchText)
           .createQuery();
         */


         org.hibernate.Query hibQuery =
            fullTextSession.createFullTextQuery(query, Sys_meta_question.class);

         List<Sys_meta_question> results = hibQuery.list();
         return results;
      }
      catch(Exception e)
      {
         throw e;
      }
   }
}
