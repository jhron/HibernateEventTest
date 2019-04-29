package hibernateeventstest


import org.hibernate.HibernateException
import org.hibernate.event.spi.PostUpdateEvent
import org.hibernate.event.spi.PostUpdateEventListener
import org.hibernate.event.spi.SaveOrUpdateEvent
import org.hibernate.event.spi.SaveOrUpdateEventListener
import org.hibernate.persister.entity.EntityPersister

class DefaultHibernateEventListener
            implements
                    SaveOrUpdateEventListener,
                    PostUpdateEventListener
    {

        @Override
        public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
                def domain = event.getEntity()
                if (domain) {
                    CustomFieldsManager.saveFields(domain, null, false)
                }
        }

        @Override
        public void onPostUpdate(PostUpdateEvent event) {
            def domain = event.getEntity()
            if (domain) {
                CustomFieldsManager.saveFields(domain, null, false)
            }
        }

        @Override
        boolean requiresPostCommitHanding(EntityPersister persister) {
            return false
        }
    }
