import {TechnologyRequest} from "./Technology-request";
import {TechnologyResponse} from "./Technology-response";

export interface FreelanceResponse{
  id:number,
  firstName:string,
  lastName:string,
  userName:string,
  city:string,
  jobTitle:string,
  imageUrl?:string,
  cvUrl?:string,
  technologyResponses?:TechnologyResponse[]
}



