package de.digitalcollections.model.api.identifiable.resource;

/** An audio file resource. Mimetype starts with "audio/". */
public interface AudioFileResource extends FileResource {

  /** @return duration in seconds */
  int getDuration();

  /** @param duration duration in seconds */
  void setDuration(int duration);
}
