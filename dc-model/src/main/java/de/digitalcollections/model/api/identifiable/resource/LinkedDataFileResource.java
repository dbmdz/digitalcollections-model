package de.digitalcollections.model.api.identifiable.resource;

import java.net.URI;

/**
 * JSON-LD is designed around the concept of a "context" to provide additional mappings from JSON to an RDF model.<br>
 * <br>
 * The 'context' links object properties in a JSON document to concepts in an ontology.<br>
 * The 'id' is an Internationalized Resource Identifier, represented by an IRI, which allows the Linked Data FileResource zto be unambiguously identified by an IRI. In our implementation we use the 'uri' field of FileResource to be the id.<br>
 * The 'type' specifies the type of object described in the document.<br>
 * <br>
 * Further information <a href="https://en.wikipedia.org/wiki/JSON-LD">JSON-LD</a>, <a href="https://en.wikipedia.org/wiki/Internationalized_Resource_Identifier">Internationalized Resource Identifier (IRI)</a>
 */
public interface LinkedDataFileResource {

  /**
   * @return the linked data context. The 'context' links object properties in a JSON document to concepts in an ontology.
   */
  URI getContext();

  /**
   * @param context set the linked data context to given context
   */
  void setContext(URI context);

  /**
   * @return the object type described in this document
   */
  String getObjectType();

  /**
   * @param objectType set the object type described in this document
   */
  void setObjectType(String objectType);
}
