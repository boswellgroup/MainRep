package uk.ac.ebi.jmzml.xml.jaxb.resolver;

import uk.ac.ebi.jmzml.MzMLElement;
import uk.ac.ebi.jmzml.model.mzml.DataProcessing;
import uk.ac.ebi.jmzml.model.mzml.Software;
import uk.ac.ebi.jmzml.model.mzml.SoftwareRef;
import uk.ac.ebi.jmzml.xml.io.MzMLObjectCache;
import uk.ac.ebi.jmzml.xml.xxindex.MzMLIndexer;

/**
 * Created by IntelliJ IDEA.
 * User: dani
 * Date: 21-Feb-2011
 * Time: 13:48:10
 * To change this template use File | Settings | File Templates.
 */
public class SoftwareRefResolver extends AbstractReferenceResolver<SoftwareRef> {
    public SoftwareRefResolver(MzMLIndexer index, MzMLObjectCache cache) {
        super(index, cache);
    }

    @Override
    public void updateObject(SoftwareRef object) {
        // if we automatically resolve the references, then update the object with the referenced object
        if (MzMLElement.SoftwareRef.isAutoRefResolving()) {
            // add objects for the refID
            String ref = object.getRef();
            if (ref != null) {
                Software refObject = this.unmarshal(ref, Software.class);
                object.setSoftware(refObject);
            }
        }
    }

    /**
     * A method to be called before the marshall process.
     * Whenever a referenced object is set, its refID should be updated
     * automatically, so that the refID and the ID of the object are
     * always in sync. Here we check that this is the case.
     *
     * @param object The Object to check for reference ID integrity.
     */
    @Override
    public void checkRefID(SoftwareRef object) {
        // if there is a referenced object and its ID does not correspond to the refID, then there is something wrong
        if (object.getSoftware() != null && !object.getRef().equals(object.getSoftware().getId())) {
            throw new IllegalStateException("Reference ID and referenced object ID do not match!");
        }
    }

    /**
     * Method to perform the afterUnmarshal operation if the resolver
     * applies to the specified object.
     *
     * @param target the object to modify after unmarshalling.
     * @param parent object referencing the target. Null if target is root element.
     */
    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (SoftwareRef.class.isInstance(target)) {
            updateObject((SoftwareRef) target);
        } // else, not business of this resolver
    }

}
