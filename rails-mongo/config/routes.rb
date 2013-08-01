MetSomeone::Application.routes.draw do
  resources :meetings
  root 'meetings#index'
end
