package de.digitalcollections.model.api.identifiable.resource;

/** A video file resource. Mimetype starts with "video/". */
public interface VideoFileResource extends FileResource {

  /** @return duration in seconds */
  int getDuration();

  /** @param duration duration in seconds */
  void setDuration(int duration);
}
