import {TechnologyRequest} from "./Technology-request";

export interface FreelanceRegistrationRequest{
  id?:number,
  firstName:string,
  lastName:string,
  userName:string,
  city:string,
  jobTitle:string,
  email:string,
  phoneNumber:string,
  imageUrl?:string,
  cvUrl?:string,
  technologyRequest?:TechnologyRequest[]
  password:string,
  confirmationPassword:string
}



