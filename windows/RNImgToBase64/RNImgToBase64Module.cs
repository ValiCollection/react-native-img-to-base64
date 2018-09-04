using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Img.To.Base64.RNImgToBase64
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNImgToBase64Module : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNImgToBase64Module"/>.
        /// </summary>
        internal RNImgToBase64Module()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNImgToBase64";
            }
        }
    }
}
