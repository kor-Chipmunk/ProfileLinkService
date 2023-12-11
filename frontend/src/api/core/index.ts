import type {
  AxiosInstance,
  Method,
  AxiosResponse,
  AxiosRequestConfig,
} from "axios";
import axios from "axios";
import { HTTP_METHOD } from "@/consts/api";

const axiosInstance: AxiosInstance = axios.create({
  baseURL: `${process.env.NEXT_PUBLIC_SERVER_DEFAULT_END_POINT}`,
  timeout: 1000,
  headers: {
    "Content-Type": "application/json",
  },
});

const handleResponse = <T>(response: AxiosResponse<T>) => {
  return response.data;
};

const createApiMethod =
  (_axiosInstance: AxiosInstance, method: Method) =>
  (
    url: AxiosRequestConfig["url"],
    config?: Omit<AxiosRequestConfig, "url">
  ): Promise<any> => {
    return _axiosInstance({
      url,
      method,
      ...config,
    }).then((res) => handleResponse(res));
  };

export default {
  get: createApiMethod(axiosInstance, HTTP_METHOD.GET),
  post: createApiMethod(axiosInstance, HTTP_METHOD.POST),
  patch: createApiMethod(axiosInstance, HTTP_METHOD.PATCH),
  put: createApiMethod(axiosInstance, HTTP_METHOD.PUT),
  delete: createApiMethod(axiosInstance, HTTP_METHOD.DELETE),
};
