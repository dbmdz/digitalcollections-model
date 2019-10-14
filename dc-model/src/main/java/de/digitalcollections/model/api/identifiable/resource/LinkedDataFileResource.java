package de.digitalcollections.model.api.identifiable.resource;

import java.net.URI;

/**
 * This class represents a linked data file resource, referenced through an uri and specified by the
 * context definition and the corresponding (object) type. A linked data file resource can be of
 * format JSON-LD (mimetype 'application/ld+json'), e.g. an IIIF Presentation Manifest or an Entity
 * Facts person description, what is the first use case being in focus.<br>
 * <br>
 * JSON-LD is designed around the concept of a "context" to provide additional mappings from JSON to
 * an RDF model.<br>
 * <br>
 * The 'context' links object properties in a JSON document to concepts in an ontology.<br>
 * The 'id' is an Internationalized Resource Identifier, represented by an IRI, which allows the
 * Linked Data FileResource to be unambiguously identified by an IRI. In our implementation we use
 * the 'uri' field of FileResource to be the id.<br>
 * The 'type' specifies the type of object described in the document.<br>
 * <br>
 * Further informations:
 *
 * <ul>
 *   <li><a href="https://en.wikipedia.org/wiki/JSON-LD">JSON-LD</a>
 *   <li><a
 *       href="https://en.wikipedia.org/wiki/Internationalized_Resource_Identifier">Internationalized
 *       Resource Identifier (IRI)</a>
 *   <li><a href="https://iiif.io/api/presentation/2.1/">IIIF Presentation API</a>
 *   <li><a
 *       href="https://www.culturegraph.org/DE/Service/DigitaleDienste/EntityFacts/entityfacts_node.html">Entity
 *       Facts der Deutschen Nationalbibliothek (DNB)</a>
 * </ul>
 */
public interface LinkedDataFileResource extends FileResource {

  /**
   * @return the linked data context. The 'context' links object properties in a JSON document to
   *     concepts in an ontology.
   */
  URI getContext();

  /** @param context set the linked data context to given context */
  void setContext(URI context);

  /** @return the object type described in this document */
  String getObjectType();

  /** @param objectType set the object type described in this document */
  void setObjectType(String objectType);
}
