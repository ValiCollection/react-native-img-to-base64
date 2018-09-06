
import { NativeModules } from 'react-native';
const { RNImgToBase64 } = NativeModules;

async function getBase64() {
  const url = 'https://static.platzi.com/static/css/logo.a76b2a87162b3b46529c30d1cb91ccc6.png';
  const base64 = await RNImgToBase64.convert(url);
  console.log(base64);
}


