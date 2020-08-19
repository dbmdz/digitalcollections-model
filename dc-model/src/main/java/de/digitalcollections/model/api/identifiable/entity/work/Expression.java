package de.digitalcollections.model.api.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.Entity;

/**
 * From https://web.library.yale.edu/cataloging/music/frbr-wemi-music#work:
 *
 * <p>A work is realized by an expression, which is embodied in a manifestation, which is
 * exemplified by an item.
 *
 * <p>An Expression is the fulfillment or realization of that idea through words, sound, image, etc.
 * that is realized by a person or corporate body.
 *
 * <p>"An expression is an intellectually/artistically concrete entity, being the realization of a
 * work in fixed alpha-numeric, musical, choreographic, cartographic, etc., notation. ... An
 * expression has no physical characteristics: in the case of textual expressions, for example, the
 * expression encompasses the words, sentences, and paragraphs of the creation, but not its font and
 * font size and hence the number of pages it constitutes when in a particular physical format."
 *
 * <p>Attributes of an expression: title, form, date, language, type of score (musical notation),
 * medium of performance (musical notation or recorded sound), identifier (if it has one), etc.
 *
 * <p>Expressions may be related by being realizations of the same work. As the notation used to fix
 * an expression is one of its major attributes, different expressions of the same work can be
 * created by fixing it in different forms. For example:
 *
 * <p>Work: Die Zauberflöte by Mozart Expression 1: original composer's score Expression 2: July 27,
 * 1949 performance by the Konzertvereinigung Wiener Staatsopernchor
 *
 * <p>Translations, revisions, arrangements, and performances of a work are considered expressions
 * of that work.
 *
 * <p>From https://www.ifla.org/files/assets/cataloguing/isbd/OtherDocumentation/resource-wemi.pdf:
 *
 * <p>"The intellectual or artistic realization of a work in the form of alpha-numeric, musical, or
 * choreographic notation, sound, image, object, movement, etc., or any combination of such forms."
 *
 * <table summary="FRBR Model">
 *   <tr><th>Domain class</th><th>Property label</th><th>Range class</th></tr>
 *   <tr><td>Work</td><td>is realized through</td><td>Expression</td></tr>
 *   <tr><td>Expression</td><td>is embodied in</td><td>Manifestation</td></tr>
 *   <tr><td>Manifestation</td><td>is exemplified by</td><td>Item</td></tr>
 *   <tr><td>Item</td><td>is exemplar of</td><td>Manifestation</td></tr>
 *   <tr><td>Manifestation</td><td>is embodiment of</td><td>Expression</td></tr>
 *   <tr><td>Expression</td><td>is realization of</td><td>Work</td></tr>
 * </table>
 */
public interface Expression extends Entity {}
