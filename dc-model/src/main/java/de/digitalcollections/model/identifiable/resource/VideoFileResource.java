package de.digitalcollections.model.identifiable.resource;

/** A video file resource. Mimetype starts with "video/". */
public class VideoFileResource extends FileResource {

  private int duration;

  public VideoFileResource() {
    super();
    this.fileResourceType = FileResourceType.VIDEO;
  }

  /** @return duration in seconds */
  public int getDuration() {
    return duration;
  }

  /** @param duration duration in seconds */
  public void setDuration(int duration) {
    this.duration = duration;
  }
}
