class MeetingSerializer < ActiveModel::Serializer
  attributes :id, :created_at

  def id
    object.id.to_s # prevents {"id": {"$oid": "deadbeaf"}} bullshit
  end
end
