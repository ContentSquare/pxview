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

  constructor(props) {
    super(props);

    this.webview = null;
    this.setWebviewRef = element => {
      this.webview = element;
    };
  }

  componentDidMount() {
    const { props } = this;
    const { addListener } = props.navigation;
    this.didFocusSubscription = addListener('didFocus', () => {
      Contentsquare.trackWebView(this.webview);
    });
  }

  componentWillUnmount() {
    Contentsquare.untrackWebView(this.webview);
    this.didFocusSubscription.remove();
  }

  render() {
    const url = `${ENCYCLOPEDIA_URL}`;
    const views = (
      <PXWebView
        nativeID={this.webViewNativeID}
        source={{
          uri: url,
        }}
        ref={this.setWebviewRef}
      />
    );
    return views;
  }
}

export default Encyclopedia;
