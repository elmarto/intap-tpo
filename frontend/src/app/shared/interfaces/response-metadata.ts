import { ResponseStatus } from './response-status';

export interface ResponseMetadata {
    status: ResponseStatus;
    values: any[];
}
