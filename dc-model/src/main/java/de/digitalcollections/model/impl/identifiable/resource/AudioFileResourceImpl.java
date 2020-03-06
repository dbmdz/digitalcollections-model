package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.AudioFileResource;
import de.digitalcollections.model.api.identifiable.resource.enums.FileResourceType;

public class AudioFileResourceImpl extends FileResourceImpl implements AudioFileResource {

  private int duration;

  public AudioFileResourceImpl() {
    super();
    this.fileResourceType = FileResourceType.AUDIO;
  }

  @Override
  public int getDuration() {
    return duration;
  }

  @Override
  public void setDuration(int duration) {
    this.duration = duration;
  }
}
