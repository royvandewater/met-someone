class MeetingsController < ApplicationController
  before_action :set_meeting, only: [:show, :edit, :update, :destroy]
  respond_to :html, :json

  def index
    @meetings = Meeting.all
    respond_with @meetings
  end

  def create
    @meeting = Meeting.new(meeting_params)

    respond_to do |format|
      if @meeting.save
        format.html { redirect_to meetings_url }
        format.json { respond_with @meeting, :status => :created, :location => @meeting }
      else
        format.html { redirect_to meetings_url }
        format.json { render :json => @meeting.errors, :status => :unprocessable_entity }
      end
    end
  end

  def destroy
    @meeting.destroy
    respond_to do |format|
      format.html { redirect_to meetings_url }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_meeting
      @meeting = Meeting.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def meeting_params
      params[:meeting]
    end
end
