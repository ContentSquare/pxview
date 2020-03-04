import React, {Component} from 'react';
import Contentsquare from '@contentsquare/react-native-sdk';
import PXWebView from '../../components/PXWebView';

const ENCYCLOPEDIA_URL =
  'https://tupeuxpastest.csq.io/mobile/web-view-cart.html';

class Encyclopedia extends Component {
  static navigationOptions = ({ navigation }) => {
    const { word } = navigation.state.params;
    return {
      title: word,
    };
  };

  webViewNativeID = 'PXWebViewWithTracking';

  componentDidMount() {
    const { props } = this;
    const { addListener } = props.navigation;
    this.didFocusSubscription = addListener('didFocus', () => {
      Contentsquare.injectEventTrackingInterface(this.webViewNativeID);
    });
    this.didBlurSubscription = addListener('didBlur', () => {
      Contentsquare.removeEventTrackingInterface(this.webViewNativeID);
    });
  }

  componentWillUnmount() {
    this.didFocusSubscription.remove();
    this.didBlurSubscription.remove();
  }

  render() {
    const url = `${ENCYCLOPEDIA_URL}`;
    const views = (
      <PXWebView
        nativeID={this.webViewNativeID}
        source={{
          uri: url,
        }}
      />
    );
    return views;
  }
}

export default Encyclopedia;
