json.array!(@meetings) do |meeting|
  json.extract! meeting, 
  json.url meeting_url(meeting, format: :json)
end